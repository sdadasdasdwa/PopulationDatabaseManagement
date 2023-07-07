import {createRouter, createWebHashHistory} from "vue-router";
import Home from '@/Home'
import Index from '@/views/Index'


const routes = [
    {
        path: '',
        name: 'Home',
        component: Home,
        children: [
            {
                path: '',
                component: Index
            }
        ]
    }
];

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router;