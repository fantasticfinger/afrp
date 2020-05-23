<template>
  <b-container fluid>
    <!-- User Interface controls -->
    <b-row>
      <b-col lg="6" class="my-1">
        <b-form-group
          label="Filter"
          label-cols-sm="3"
          label-align-sm="right"
          label-size="sm"
          label-for="filterInput"
          class="mb-0"
        >
          <b-input-group size="sm">
            <b-form-input
              v-model="filter"
              type="search"
              id="filterInput"
              placeholder="Type to Search"
            ></b-form-input>
            <b-input-group-append>
              <b-button :disabled="!filter" @click="filter = ''">Clear</b-button>
            </b-input-group-append>
          </b-input-group>
        </b-form-group>
      </b-col>

      <b-col lg="6" class="my-1">
        <b-form-group
          label="Filter On"
          label-cols-sm="3"
          label-align-sm="right"
          label-size="sm"
          description="Leave all unchecked to filter on all data"
          class="mb-0">
          <b-form-checkbox-group v-model="filterOn" class="mt-1">
            <b-form-checkbox value="down">Down</b-form-checkbox>
            <b-form-checkbox value="plays">Plays</b-form-checkbox>
            <b-form-checkbox value="isActive">Active</b-form-checkbox>
          </b-form-checkbox-group>
        </b-form-group>
      </b-col>


    <b-col lg="6" class="my-1">
        <b-form-group
          label="Sort"
          label-cols-sm="3"
          label-align-sm="right"
          label-size="sm"
          label-for="sortBySelect"
          class="mb-0"
        >
          <b-input-group size="sm">
            <b-form-select v-model="sortBy" id="sortBySelect" :options="sortOptions" class="w-75">
              <option slot="first" value="">-- none --</option>
            </b-form-select>
            <b-form-select v-model="sortDesc" size="sm" :disabled="!sortBy" class="w-25">
              <option :value="false">Asc</option>
              <option :value="true">Desc</option>
            </b-form-select>
          </b-input-group>
        </b-form-group>
      </b-col>   
      <b-col sm="5" md="6" class="my-1">
        <b-form-group
          label="Per page"
          label-cols-sm="6"
          label-cols-md="4"
          label-cols-lg="3"
          label-align-sm="right"
          label-size="sm"
          label-for="perPageSelect"
          class="mb-0"
        >
          <b-form-select
            v-model="perPage"
            id="perPageSelect"
            size="sm"
            :options="pageOptions"
          ></b-form-select>
        </b-form-group>
      </b-col>
    </b-row>
    <br />
        
    <!-- Main table element -->
    <b-table
      show-empty
      small
      :items="items"
      :fields="fields"
      :current-page="currentPage"
      :per-page="perPage"
      :filter="filter"
      :filterIncludedFields="filterOn"
      :sort-by.sync="sortBy"
      :sort-desc.sync="sortDesc"
      :sort-direction="sortDirection"
      @filtered="onFiltered"
    >
      <template slot="[name]" slot-scope="row">
        {{ row.value.first }} {{ row.value.last }}
      </template>

      <template slot="row-details" slot-scope="row">
        <b-card>
          <ul>
            <li v-for="(value, key) in row.item" :key="key">{{ key }}: {{ value }}</li>
          </ul>
        </b-card>
      </template>
    </b-table>
    
    <b-pagination
          v-model="currentPage"
          :total-rows="totalRows"
          :per-page="perPage"
          align="fill"
          size="sm"
          class="my-0"
    ></b-pagination>
    <br />
  </b-container>
</template>

<script>
  export default {
    data() {
      return {
        items: [
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"Iilegal Formation" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
          { num: 1, offence_team: "Home", ball_on: "+12", down : "1", plays:"P", tackle_by:"11" ,gain_yd:11, foul:"" },
        ],
        fields: [
          { key: 'num', label: 'Num', sortable: true, sortDirection: 'desc' },
          { key: 'offence_team', label: 'Offence Team', sortable: true, sortDirection: 'desc' },
          { key: 'ball_on', label: 'Ball On', sortable: true, sortDirection: 'desc' },
          { key: 'down', label: 'Down'},
          { key: 'plays', label: 'Plays'},
          { key: 'tackle_by', lavel: 'Tackle By', sortable: true, sortDirection: 'desc'},
          { key: 'gain_yd', label: 'Gain Yd', sortable: true, sortDirection: 'desc' },
          { key: 'foul', label: 'Foul'}
          
        ],
        totalRows: 1,
        currentPage: 1,
        perPage: 15,
        pageOptions: [15,30,45,60],
        sortBy: '',
        sortDesc: false,
        sortDirection: 'asc',
        filter: null,
        filterOn: []
      }
    },
    computed: {
      sortOptions() {
        // Create an options list from our fields
        return this.fields
          .filter(f => f.sortable)
          .map(f => {
            return { text: f.label, value: f.key }
          })
      }
    },
    created(){
      
    },
    mounted() {
      // Set the initial number of items
      this.totalRows = this.items.length
    },
    methods: {
      onFiltered(filteredItems) {
        // Trigger pagination to update the number of buttons/pages due to filtering
        this.totalRows = filteredItems.length
        this.currentPage = 1
      }
    }
  }
</script>

<style scoped>

</style>