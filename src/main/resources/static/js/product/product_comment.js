/**
 * 
 */
console.log("dsffsdfsdf");

const list = document.getElementById("list");
const commentAdd = document.getElementById("commentAdd");

commentAdd.addEventListener("click", ()=>{
	console.log("aaaaaaaaaaaa")
})


let num = list.getAttribute("data-product-num");
fetch(`./commentList?productNum=${num}`)
	.then(r => r.text())
	.then(r => {
			list.innerHTML=r;
		
	})
	.catch(e => console.log(e))

;