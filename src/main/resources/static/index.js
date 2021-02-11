`use strict`;


const listName = document.querySelector("#name");
const id = document.querySelector("#ID");
let host = "http://localhost:8080/";
const todolist = document.querySelector("#todo");
const alert = document.querySelector("#onsuccess");
const alertupdate = document.querySelector("#onsuccessupdate");


const printNameToScreen = (listName) => {
	let user = document.createElement("p"); // <p> </p>
	let text = document.createTextNode(`${listName}`); // username
	user.appendChild(text); // <p> username </p>
	todolist.appendChild(user);
}



const createToDoList = () => {
	const todoList = listName.value;

	let data = {
		listName: todoList
	}


	fetch("http://localhost:8080/todo/create", {
		method: "POST",
		body: JSON.stringify(data),
		headers: { "Content-Type": "application/json" }
	})
		.then(response => response.json())
		.then(info => {
			console.log(info);
			console.log("success");
			alert.setAttribute("class", "alert alert-success");
			alert.innerHTML = `${todoList} has been created`;
			setTimeout(() => {
				alert.removeAttribute("class");
				alert.innerHTML = "";
			}, 2000);
		})
		.catch(err => console.error(`ERROR = ${err}`));
}






const deleteToDoList = () => {
	const deleteID = id.value;


	fetch(`http://localhost:8080/todo/delete/${deleteID}`, {
		method: "DELETE",
	}).then((response) => {
		if (response.status != 204) {
			throw new Error(`i dont have a status of 204`);
		} else {
			console.log(response);
			console.log(`response is okay (204)`);
			console.log(`your to do with id ${deleteID} was deleted `);

		}
	}).catch((err) => {
		console.error(err);
	})
}

const readAllToDo = () => {
	fetch(`http://localhost:8080/todo/readAll`, {
		method: "GET",
	})
		.then(response => response.json())
		.then(info => {
			console.log(info);
		})
		.catch(err => console.error(`ERROR = ${err}`));
}


const readOneMethod = () => {

	const readID = id.value;


	fetch(`http://localhost:8080/todo/read/${readID}`, {
		method: "GET",
	})
		.then(response => response.json())
		.then(info => {
			console.log(info);
			if (response.status != 200) {
				console.log(`A todoList with ${readID} does not exit, please enter a correct ToDo ID `);
				throw new Error(`i dont have a status of 200`);
		} else {	
			console.log(response);
			console.log(`response is okay (200)`);
		}
	}).catch((err) => {
	})
}




