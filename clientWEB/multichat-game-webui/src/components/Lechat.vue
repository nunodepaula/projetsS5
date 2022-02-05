<div>
<h1>Mon app</h1>
  {{ info }}
</div>


<script>
import axios from "axios"
export default{
    name:'Lechat',
    data (){
        return {
        info: null
        }
    },
    created () {
        axios
        .get('http://localhost:8080/services/canaux-disponibles')
        .then(response => (this.info = response))
         
    }
    }

</script>