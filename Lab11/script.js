(() => {

})();

let myChart;

async function generateChart(){
    const n = document.getElementById("numberOfCountries").value;
    const countries = [...Array()];
    const populations = [...Array()];
    const response = await fetch("https://restcountries.com/v3.1/all"); 
    const result =await response.json();
    // console.log(result);
    for(i=0;i<n;i++){
        const {name:{common} , population} = result[i];
        countries.push(common);
        populations.push(population)
    }
    console.log(countries);
    printChart(countries,populations);
    document.getElementById("numberOfCountries").value = 0;
    // const {}  = response.json()
}   

function printChart(countries, populations) {
    const canvas = document.getElementById("barChart")
    const ctx = canvas.getContext("2d");
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    if (myChart) {
        myChart.destroy();
    }
    const randomColors = Array.from({ length: populations.length }, () =>
        `rgba(${Math.floor(Math.random() * 256)}, ${Math.floor(Math.random() * 256)}, ${Math.floor(Math.random() * 256)}, 0.7)`
    );
    myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: countries,
            
            datasets: [{
                label: 'poplation',
                data: populations,
                // backgroundColor: 'rgba(89, 240, 177, 0.8)', 
                backgroundColor: randomColors,
                // borderColor: 'rgba(240, 149, 89, 1)', 
                borderColor: randomColors,
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    grid: {
                        color: 'rgba(0, 0, 0, 0.1)' // Adjust the grid color
                    }
                }
            }
        }
    });
}
