<template>
  <div>
      <b-form @submit="onSubmit" @button="onCancel">
    <b-container>
        <b-row>
           
    
    
     <b-col>
    <b-form-group id="select-group-1" label="경기선택:" label-for="select-1">
        <b-form-select v-model="selected">
            <option v-for="(game) in games" :key="game.num" :value="game.num">GameDay:{{game.gameday}}Home:{{game.home_team}}Away:{{game.away_team}}</option>
            
        </b-form-select>
    </b-form-group>
    </b-col>
    </b-row>
    <b-row>
    <b-col>
    <b-form-group id="radio-group-1" label="Home / Away" label-for="radio-1">
      <b-form-radio-group
        v-model="offenceT"
        :options="options1"
        name="offence_team"
      ></b-form-radio-group>
    </b-form-group>
    </b-col>
    </b-row>
     <b-row>
          <b-col lg="6" class="my-1">
    <b-form-group id="input-group-1" label="BallOn:" label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="form.ball_on"
          type="text"
          required
        ></b-form-input>
      </b-form-group>
          </b-col>


 <b-col lg="6" class="my-1">
      <b-form-group id="input-group-2" label="Down:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.down"
          required
        ></b-form-input>
      </b-form-group>
 </b-col>
     </b-row>

<b-row>
     <b-col lg="6" class="my-1">
    <b-form-group id="radio-group-2" label="Plays (Run/Pass/KicK)" label-for="radio-2">
      <b-form-radio-group
        v-model="plays"
        :options="options2"
        name="plays"
      ></b-form-radio-group>
    </b-form-group>
     </b-col>
      <b-col lg="6" class="my-1">
 <b-form-group id="input-group-3" label="Player:" label-for="input-2">
        <b-form-input
          id="input-3"
          v-model="form.player"
          required
        ></b-form-input>
      </b-form-group>


      </b-col>
</b-row>
<b-row>
     <b-col lg="6" class="my-1">
      <b-form-group id="input-group-4" label="Tackle By:" label-for="input-3">
        <b-form-input
          id="input-4"
          v-model="form.tackle_by"
          required
        ></b-form-input>
      </b-form-group>
     </b-col>
 <b-col lg="6" class="my-1">
      <b-form-group id="input-group-5" label="Gain Yard:" label-for="input-4">
        <b-form-input
          id="input-5"
          v-model="form.gain_yd"
          required
        ></b-form-input>
      </b-form-group>
 </b-col>
</b-row>
      <b-form-group id="input-group-6" label="Foul/Remark:" label-for="input-5">
        <b-form-input
          id="input-6"
          v-model="form.foul"
          required
        ></b-form-input>
      </b-form-group>
       <b-col lg="6" class="my-1">
      <b-button type="submit" variant="primary">작전등록</b-button>
        &nbsp;
      <b-button type="button" variant="danger">&nbsp;&nbsp;취소&nbsp;&nbsp;</b-button>
        </b-col>


    
    
        
    </b-container>
    </b-form>
    <div class="mt-3">Selected: <strong>{{ selected }}</strong></div>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    data () {
      return {
        selected: '',
        games: [

        ],
        records: [{
          home_team: '',
          away_team: '',
          gameday: ''
        }],
        
         form: {
          email: '',
          name: '',
          food: null,
          checked: []
        },
        offenceT: 'H',
        options1: [
          { text: 'Home', value: 'H' },
          { text: 'Away', value: 'A' }
        ],
        plays: 'R',
        options2: [
          { text: 'Run', value: 'R' },
          { text: 'Pass', value: 'P' },
          { text: 'Kick', value: 'K' }
        ]
        
      }
    },
    created(){
        axios.get('http://127.0.0.1:8081/game')
             .then((res) =>{
               this.games = res.data
               console.log(this.games)
             })
             .catch((err)=>{

             }) 
      },
    methods: {
      onSubmit(){
        
      },
      onCancel(){

      }

    }
  }
</script>