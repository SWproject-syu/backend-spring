<template>
  <div class="container">
    <div class="flex">
      <input
        class="input"
        type="text"
        placeholder="검색하실 은행을 입력해주세요."
        @change="input"
      />
      <button class="button" @click="click(originData)">검색</button>
    </div>
    <div v-for="item in data" :key="item.fin_co_no" class="list_border">
      <!-- {{ item }} -->
      <div class="flex">({{ item.kor_co_nm }}){{ item.fin_prdt_nm }}</div>
      <div class="flex">신청 방법: {{ item.join_way }}</div>
      <div class="flex">신청 대상자: {{ item.join_member }}</div>

      <div class="list">
        <div v-for="item2 in item.optionList" :key="item2.months">
          <div class="flex reverse">
            <div class="list_item2">
              {{ item2.months }}
            </div>
            <div class="list_item2">
              {{ item2.increse }}
            </div>
            <div class="list_item2">
              {{ item2.type }}
            </div>
          </div>
        </div>
      </div>

      <!-- <div class="flex">만기 후 이자율</div>
      <div class="list">
        <div v-for="percent in item.mtrt_int.split('\n')" :key="percent">
          <div class="flex reverse">
            {{ percent.replace('만기 후', '') }}
          </div>
        </div>
      </div> -->
    </div>

    <!-- {{ originData }} -->
    <!-- {{ bankList }} -->
    <!-- {{ join_way }} -->
  </div>
</template>

<script lang="ts">
import { defineComponent, Ref } from 'vue'
import axios from 'axios'
import { ref } from 'vue'
export default defineComponent({
  name: 'SearchPage',
  setup() {
    const response: Ref<null | {
      dcls_end_day: null | string
      dcls_month: string // '202204'
      dcls_strt_day: string // '20220420'
      etc_note: string // '1. 이 예금의 계약기간은 6개월, 1년, 2년으로 한다.\n2. 1인 1계좌이며, 가입금액은 최소 1백만원 이상 최고 1억원 이하이다.'
      fin_co_no: string // '0010024'
      fin_co_subm_day: string // '202204271654'
      fin_prdt_cd: string // '21001203'
      fin_prdt_nm: string // 'BNK주거래우대정기예금'
      join_deny: string // '1'
      join_member: string // '개인 및 개인사업자'
      join_way: string // '인터넷,스마트폰'
      kor_co_nm: string // '경남은행'
      max_limit: number //100000000
      mtrt_int: string //'만기 후 1개월 이내: 일반정기예금 기본이율 Ⅹ50%\n만기 후 1개월 초과: 일반정기예금 기본이율 Ⅹ20%'
      optionList: { increse: string; type: string; months: string }[]
      // { increse: 2; type: '단리'; months: '12' },
      // { increse: 2.05; type: '단리'; months: '24' }
      spcl_cnd: string
    }> = ref(null)
    const bankList = ref([])
    const originData: Ref<null | {
      dcls_end_day: null | string
      dcls_month: string // '202204'
      dcls_strt_day: string // '20220420'
      etc_note: string // '1. 이 예금의 계약기간은 6개월, 1년, 2년으로 한다.\n2. 1인 1계좌이며, 가입금액은 최소 1백만원 이상 최고 1억원 이하이다.'
      fin_co_no: string // '0010024'
      fin_co_subm_day: string // '202204271654'
      fin_prdt_cd: string // '21001203'
      fin_prdt_nm: string // 'BNK주거래우대정기예금'
      join_deny: string // '1'
      join_member: string // '개인 및 개인사업자'
      join_way: string // '인터넷,스마트폰'
      kor_co_nm: string // '경남은행'
      max_limit: number //100000000
      mtrt_int: string //'만기 후 1개월 이내: 일반정기예금 기본이율 Ⅹ50%\n만기 후 1개월 초과: 일반정기예금 기본이율 Ⅹ20%'
      optionList: { increse: string; type: string; months: string }[]
      // { increse: 2; type: '단리'; months: '12' },
      // { increse: 2.05; type: '단리'; months: '24' }
      spcl_cnd: string
    }> = ref(null)

    const join_way = ['영업점', '인터넷', '스마트폰']
    const getBankData = () => {
      return new Promise((resolve) => {
        axios
          .get('http://localhost:8080/search/', {
            headers: {
              'Content-Type': 'text/html; charset=utf-8',
              'Access-Control-Allow-Origin': '*',
              Accept: '*/*',
            },
          })
          .then((r) => {
            // r = r.data.result
            // response.value.push(r)
            //             result: {prdt_div: "D", total_count: "50", max_page_no: "1", now_page_no: "1", err_cd: "000", err_msg: "정상",…}
            // baseList: [{dcls_month: "202204", fin_co_no: "0010001", fin_prdt_cd: "WR0001A", kor_co_nm: "우리은행",…},…]
            // err_cd: "000"
            // err_msg: "정상"
            // max_page_no: "1"
            // now_page_no: "1"
            // optionList: [{dcls_month: "202204", fin_co_no: "0010001", fin_prdt_cd: "WR0001A", intr_rate_type: "S",…},…]
            // [0 … 99]
            // [100 … 130]
            // prdt_div: "D"
            // total_count: "50"
            response.value = r.data.result.baseList.map((item) => {
              if (!bankList.value.includes(item.kor_co_nm) && !!item.kor_co_nm)
                bankList.value.push(item.kor_co_nm)
              return {
                ...item,
                optionList: r.data.result.optionList
                  .filter((item2) => item2.fin_prdt_cd == item.fin_prdt_cd)
                  .map((item) => {
                    return {
                      increse: item.intr_rate,
                      type: item.intr_rate_type_nm,
                      months: item.save_trm,
                    }
                  }),
              }
            })
            console.log(response.value)
            originData.value = response.value
            resolve(true)
          })
      })
    }
    getBankData()
    //.then(() => getBankData(2))
    return { data: response, bankList, join_way, originData: originData }
  },
  data() {
    return {
      text: '', //출력될 값
      inputText: '', //input값
    }
  },
  methods: {
    input(e) {
      return (this.inputText = e.target.value) //input에 입력된 값을 inputText로 넣어주기
    },
    click(originData: { kor_co_nm: string }[]) {
      this.data = originData.filter((item) => item.kor_co_nm.includes(this.inputText))
    },
  },
})
</script>
<style>
.input {
  width: 100%;
  margin: 8px;
  padding: 8px;
  font-size: 32px;
  border: 1px solid gray;
  font-weight: bold;
  border-radius: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex: 8;
}
.button {
  width: 100%;
  padding: 8px;
  margin: 8px;
  font-size: 30px;
  font-weight: bold;
  background-color: aliceblue;
  justify-content: center;
  align-items: center;
  flex: 2;
  display: flex;
}
.flex {
  display: flex;
}
.reverse {
  flex-direction: row;
}
.list_item {
  padding: 8px;
}
.list_item2 {
  flex: 1;
}
.list {
  padding: 8px;
}
.list_border {
  border: 1px solid gray;
  margin-bottom: 16px;
  font-size: 24px;
}
.list_border > * {
  margin-bottom: 8px;
  font-size: 24px;
}
</style>
