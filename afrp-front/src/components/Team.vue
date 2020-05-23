<template>



  <div>
    <b-form @submit.prevent="onSubmit(form)" >
      <b-input-group prepend="TeamName" class="mt-3">
        <b-form-input v-model="team_name"></b-form-input>
        <b-input-group-append>
        <b-button variant="info" @click="Search">Search</b-button>
        </b-input-group-append>
      </b-input-group>
    </b-form>

    <table class="table">
  <thead>
    <tr>
      <th>Team</th>
      <th>Coach</th>
      <th>Num</th>
      <th>captain</th>
      <th>Enroll</th>
    </tr>
  </thead>
  <tbody id = "records">
    <!-- <tr v-for="record in records"> -->
    <tr v-for="(record) in records" :key="record.coach_name" >
        <td>{{record.team_name}}</td>
        <td>{{record.coach_name}}</td>
        <td>{{record.num_member}}</td>
        <td>{{record.captain}}</td>
        <td><b-button @click="onEnroll" variant="success">신청</b-button></td>

      
       
      
    </tr>
  </tbody>
</table>


  </div>
</template>




<script>



import axios from 'axios'
  export default {
    data() {
    return {
      team_name: "",
      records : []
      
    }
  },
  watch(){

  },
  created(){
    axios.get('http://127.0.0.1:8081/team/team',{
            params:{
                team : ''
            }
            })
             .then((res)=>{
                 console.log(res.data)
                 this.records = res.data
                 
             })
             .catch((err)=>{

             })
  },
        
    methods: {
        Search(){
            axios.get('http://127.0.0.1:8081/team/team',{
            params:{
                team : this.team_name
            }
            })
             .then((res)=>{
                 console.log(res.data)
                 this.records = res.data
                 
             })
             .catch((err)=>{

             })
        },
        onEroll() {
            axios.get('http://127.0.0.1:8081/user/user')
               .then((data) => alert(data)
                .catch((err) => alert('요청불가'))
                )
        }
    }
  }
</script>
<style>

</style>