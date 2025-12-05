/**
 * 
 */
console.log("dsffsdfsdf");

fetch("./commentList?productNum=2")
	.then(r => r.text())
	.then(r => console.log(r))
	.catch(e => console.log(e))

;