import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

const clientApiService = require('services/ClientApiService.js');

export default new Vuex.Store({
    state: {

        hasServerAuthorisation: false,

        user: {
            currentProfile: null,
            instProfile: null,
            instFollowers: null
        }

    },

    mutations: {
        setCurrentProfile(currentState, currentProfile) {
            currentState.currentProfile = currentProfile
        },


        setInstFollowers(currentState, instFollowers) {
            currentState.instFollowers = instFollowers
        },
        setInstProfile(currentState, profile) {
            currentState.instProfile = profile
        },
        logoutUser(currentState) {
            currentState.instProfile = null
            currentState.instFollowers = null
        }
    },

    actions: {

        authUser(userDto) {
            console.log('authUser(user)', userDto)
            this.state.user.currentProfile = userDto;
            this.state.hasServerAuthorisation = true;
        },


        isUserAuth() {
            console.log('this.state.currentProfile != null',this.state.currentProfile != null)
            return this.state.currentProfile != null;
        },

        /*hasAuth(context) {
            const hasAuth = clientApiService.hasAuth()

            let user = {

            }

            if (hasAuth) {
                console.log('hasAuth')
                this.authUser(user)
            }
            else {
                console.log('NO AUTH')
            }
        },*/


        async doLogout(context) {
            context.commit('logoutUser')
            window.location.href = 'https://localhost:8080/logout'
        },

        loadInstDataToStorage(context, instFollowers) {
            context.commit('setInstFollowers', instFollowers)
        },
        loadInstUserProfile(context, instProfile) {
            context.commit('setInstProfile', instProfile)
            axios.post('/api/social/instagram/graph/save_profile', instProfile).then(value => {
                console.log(value)
            })
        },
        doGoogleAuth() {
           /*window.open('http://localhost:8080/login', '_blank');*/
            window.location.href = 'https://localhost:8080/login'
        }
    },
    plugins: [createPersistedState()]
});