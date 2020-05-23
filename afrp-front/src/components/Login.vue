<template>
  <div style="position: absolute; top:37%; left:40%">
    <b-form @submit.prevent="onSubmit(form)" >
      <b-form-group
        id="input-group-1"
        label="ID"
        label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="form.user_id"
          required
          placeholder="Enter id"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Password" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.user_pw"
          type="password"
          required
          placeholder="Enter Password"
        ></b-form-input>
      </b-form-group>

      <b-button type="submit" variant="primary">로그인</b-button>
      <b-button @click="onJoin" type="button" variant="danger">회원가입</b-button>
    </b-form>
   
  </div>
</template>


<script>
import axios from 'axios'
  export default {
    name : 'Login' ,
    data() {
      return {
        form: {
          user_id: '',
          user_pw: '',
        },
      }
    },
    methods: {
      onSubmit(form) {
        console.log(form.user_id)
               this.$store.dispatch('LOGIN', {form})        
               .then(() => {
                  console.log(this.$store.state.access_token)
                  console.log(localStorage.authenticated)
                  this.redirect()
               })
               .catch(({err})=> alert('로그인실패 :' + err))
            },
  redirect() {
      // 리다이렉트 처리
      this.$router.push({path: '/operation/search'})
    },

      onJoin() {
        this.$router.push({path: '/join'})
      }
    }
  }
</script>
<style>

</style>