<template>
  <div>
    <h3>파일 업로드 결과: { { this.response === '' ? 'waiting' : this.response } }</h3>
    <div>
      <button @click="selectUploadFile()">이미지 선택</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CorsReuqest",
  data() {
    return {
      response: "",
    };
  },
  methods: {
    selectUploadFile() {
      var vue = this;
      let elem = document.createElement("input");
      elem.type = "file";
      elem.accept = "audio/*"//"image/*";
      elem.multiple = true;
      // 클릭
      elem.click();
      // 이벤트 감지
      elem.onchange = function () {
        const formData = new FormData();
        for (var index = 0; index < this.files.length; index++) {
          console.log(this.files[index]);
          formData.append("fileList", this.files[index]);
        }
        // axios
        //   .get("http://localhost:8080/", {
        //     headers: { "Content-Type": "application/json; charset = utf-8", "Access-Control-Allow-Origin": "*" },
        //   })
        //   .then((response) => {
        //     vue.response = response.data;
        //     console.log(response);
        //   })
        //   .catch((error) => {
        //     console.log(error);
        //     vue.response = error.message;
        //   });
        axios
          .post("http://localhost:8080/api/file/upload/image", formData, {
            "Content-Type": "multipart/form-data; charset = utf-8",
            "Access-Control-Allow-Origin": "*",
          })
          .then((response) => {
            vue.response = response.data;
            console.log(response);
          })
          .catch((error) => {
            vue.response = error.message;
            console.log(error.message);
          });
      };
    },
  },
};
</script>
