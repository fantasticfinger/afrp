import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';


Vue.use(Vuex);
const resourceHost = 'http://127.0.0.1:8081'

const enhanceAccessToeken = () => {
    const { access_token } = localStorage
    if (!access_token) return
    axios.defaults.headers.common['Authorization'] = `Bearer ${access_token}`;
}
enhanceAccessToeken()

export default new Vuex.Store({
    state: {
        access_token: null,
        authenticated: null
    },
    getters: {

    },
    mutations: {
        LOGIN(state, data) {
            state.access_token = data.access_token
            localStorage.access_token = data.access_token
            localStorage.authenticated = true;
        },
        LOGOUT(state) {
            state.access_token = null
            delete localStorage.access_token
            delete localStorage.authenticated;
        }
    },
    actions: {
        LOGIN({ commit }, { form }) {
            /*eslint no-console: "error"*/
            // eslint-disable-next-line no-console
            return axios.post(`${resourceHost}/oauth2/login`, form)
                .then(({ data }) => {
                    // LOGIN 변이 실행
                    commit('LOGIN', data)
                    axios.defaults.headers.common['Authorization'] = `Bearer ${data.access_token}`
                })
                .catch(({ err }) => alert('전송실패 :' + err))
        },
        LOGOUT({ commit }) {
            axios.defaults.headers.common['Authorization'] = undefined
            commit('LOGOUT')
        }
    }

})