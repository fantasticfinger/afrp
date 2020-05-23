<template>
<div>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#/login">AFRP</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      
     <b-navbar-nav class="l-auto">
      <b-navbar-nav>
        <b-nav-item href="/team">Team</b-nav-item>
        <b-nav-item href="/game/regist">Game</b-nav-item>
      </b-navbar-nav>
      <b-nav-item-dropdown left>
          <!-- Using 'button-content' slot -->
          <template slot="button-content">operation</template>
          <b-dropdown-item href="/operation/regist">Regist</b-dropdown-item>
          <b-dropdown-item href="/operation/search">Search</b-dropdown-item>
        </b-nav-item-dropdown>
    </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">

        <b-nav-item-dropdown text="User" right>
          <b-dropdown-item href="#">My Account</b-dropdown-item>
          <b-dropdown-item href="" @click.prevent="onClickLogout">Logout</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>

<script>
 //import store from '../store'

  export default {
    computed: {
     // isAuthenticated() {
     //   return store.getters.isAuthenticated
     // }
    },
    methods: {
      onClickLogout() {
        this.$store.dispatch('LOGOUT').then(() => this.$router.push('/'))
      }
    }
  }
</script>