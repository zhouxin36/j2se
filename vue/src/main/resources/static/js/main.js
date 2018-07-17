var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!'
    }
})
var app2 = new Vue({
    el: '#app-2',
    data: {
        message: '页面加载于 ' + new Date().toLocaleString()
    }
})
var app3 = new Vue({
    el: '#app-3',
    data: {
        seen: true
    }
})
var app4 = new Vue({
    el: '#app-4',
    data: {
        todos: [
            { text1: '学习 JavaScript' },
            { text1: '学习 Vue' },
            { text1: '<p style="color: aqua">整个牛项目 </p>' }
        ]
    }
})
var app5 = new Vue({
    el: '#app-5',
    data: {
        message: 'Hello Vue.js!'
    },
    methods: {
        reverseMessage: function (e) {
            console.log($(e.target).attr("name"));
            console.log($("#uiosfh").attr("name"));

            this.message = this.message.split('').reverse().join('')
        }
    }
})
var app6 = new Vue({
    el: '#app-6',
    data: {
        message: 'Hello Vue!'
    },
    computed: {
        reversedMessage: function () {
            return this.message.split('').reverse().join('')
        }
    }
})
Vue.component('todo-item', {
    props: ['todo'],
    template: '<li style="color: aqua">{{todo.text}}</li>'
})

var app7 = new Vue({
    el: '#app-7',
    data: {
        groceryList: [
            { id: 0, text: '蔬菜' },
            { id: 1, text: '奶酪' },
            { id: 2, text: '随便其它什么人吃的东西' }
        ],
        innerHTML: "<p style='color: #00ee00'>哈哈哈</p>"
    }
})

var app8 = new Vue({
    el:'#app-8',
    data: {
        op : 10
    },
    methods:{
        choose: function () {
            if(this.op == 10)
                this.op = 8
            else
                this.op = 10
        }
    }
})

var vm = new Vue({
    el: '#demo',
    data: {
        firstName: 'Foo',
        lastName: 'Bar'
        // fullName: 'Foo Bar'
    },
    // watch: {
    //     firstName: function (val) {
    //         console.log("---》"+val);
    //         this.fullName = val + ' ' + this.lastName
    //     },
    //     lastName: function (val) {
    //         console.log("《---》"+val);
    //         this.fullName = this.firstName + ' ' + val
    //     }
    // },
    computed: {
        fullName: {
            // getter
            get: function () {
                return this.firstName + ' ' + this.lastName
            },
            // setter
            set: function (newValue) {
                var names = newValue.split(' ')
                this.firstName = names[0]
                this.lastName = names[names.length - 1]
            }
        }
    }
})

var app9=new Vue({
    el: 'app-9',
    data: {
        selected: 'A',
        options: [
            { text: 'One', value: 'A' },
            { text: 'Two', value: 'B' },
            { text: 'Three', value: 'C' }
        ]
    }
})