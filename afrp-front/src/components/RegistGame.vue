<template>
  <div>
    <b-form @submit.prevent="onSubmit(form)" @button="onCancel">
    <b-form-group id="input-group-1" label="경기날짜:" label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="form.gameday"
          type="date"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Home Team:" label-for="input-2">
        <b-form-input
          id="input-2"
          type="text"
          v-model="form.home_team"
          required
        ></b-form-input>
      </b-form-group>
      

      <b-form-group id="input-group-3" label="Away Team:" label-for="input-3">
        <b-form-input
          id="input-3"
          type="text"
          v-model="form.away_team"
          required
        ></b-form-input>
      </b-form-group>

      <b-button type="submit" variant="primary">등록</b-button>
      <b-button @click="onCancel" type="button" variant="danger">취소</b-button>
    
    </b-form>
  </div>
</template>

<script>
import axios from 'axios'
  export default {
    
    data : function() {
      return {
         form: {
          gameday: '',
          home_team: '',
          away_team: ''
        },
      }
    },
    methods: {
      onCancel(){
        this.form.gameday = ''
        this.form.home_team = ''
        this.form.away_team = ''

      },
      onSubmit(form){
        console.log(form.date)
         axios.put('http://127.0.0.1:8081/game',form)
             .then((data)=>{

             })
             .catch((err)=>{

             })
      }
    }
  }
</script>