// router/index.js
import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/components/Login.vue'
import CreateUser from '@/components/CreateUser.vue'
import SearchOperation from '@/components/SearchOperation.vue'
import RegistOperation from '@/components/RegistOperation.vue'
import Team from '@/components/Team.vue'
import RegistGame from '@/components/RegistGame.vue'

const requireAuth = () => (from, to, next) => {
    if (localStorage.authenticated) return next()
    next('/login')
}


// 뷰 어플리케이션에 라우터 플러그인을 추가한다.
Vue.use(VueRouter)

export default new VueRouter({
    mode: "history",
    routes: [
        { path: '/', component: Login },
        { path: '/login', component: Login },
        { path: '/join', component: CreateUser },
        { path: '/team', component: Team, beforeEnter: requireAuth() },
        { path: '/operation/search', component: SearchOperation, beforeEnter: requireAuth() },
        { path: '/operation/regist', component: RegistOperation, beforeEnter: requireAuth() },
        { path: '/game/regist', component: RegistGame, beforeEnter: requireAuth() }

    ]
})