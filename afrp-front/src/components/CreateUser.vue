<template>
  <div>
    <b-form @submit.prevent="onSubmit(form)">

 <b-form-group label="회원가입 유형:">
      <b-form-radio-group
        id="btn-radios-1"
        v-model="form.type"
        :options="options"
        name="radios-btn-default"
      ></b-form-radio-group>
    </b-form-group>

    <b-form-group id="input-group-1" label="Id:" label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="form.id"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Password:" label-for="input-2">
        <b-form-input
          id="input-2"
          type="password"
          v-model="form.pw"
          required
        ></b-form-input>
      </b-form-group>
      

      <b-form-group id="input-group-3" label="Password Check:" label-for="input-3">
        <b-form-input
          id="input-3"
          type="password"
          v-model="form.pwck"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-4" label="Name:" label-for="input-4">
        <b-form-input
          id="input-4"
          v-model="form.name"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-5" label="phone:" label-for="input-5">
        <b-form-input
          id="input-5"
          v-model="form.phone"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-6" label="email" label-for="input-6">
        <b-form-input
          id="input-6"
          v-model="form.email"
          required
        ></b-form-input>
      </b-form-group>
      
      <b-button type="submit" variant="primary">가입</b-button>
      <b-button @click="onCancel" type="button" variant="danger">취소</b-button>


    
    </b-form>
  </div>
</template>

<script>
  export default {
    data : function() {
      return {
       
        form: {
            id: '',
            pw: '',
            pwck: '',
            name: '',
            phone: '',
            email: '',
            type: 'ROLE_PLAYER',
        
        },
        options: [
          { text: '선수', value: 'ROLE_PLAYER' },
          { text: '감독', value: 'ROLE_COACH' },
        ],
      }
    },
    methods: {
      onSubmit(form){
        if(form.pw != form.pwck){
          alert("비밀번호가 서로 다릅니다")
          return;
        }

        this.$axios.post(`http://127.0.0.1:8081/user/user`, form )
                .then(( data ) => {
                    if(data.status===200){
                      this.$router.push({path: '/login'})
                    }
                })
                .catch(({ err }) => alert('회원가입실패 :' + err))
      },
      onCancel() {
         this.$router.push({path: '/login'})
      },
      redirect() {
      // 리다이렉트 처리
      this.$router.push({path: '/login'})

      }
    },
    computed: {

    }
  } 
</script>