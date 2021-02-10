 
`use strict`;

    const readAllTasks = () => {
        fetch("http://localhost:8080/task/read/2")
            .then((response) => {
                if (response.status !== 200) {
                    throw new Error("Error, this has not worked");
                } else {
                    console.log(response);
                    console.log(`OK - 200, this has worked`);
                    //json-ify it (which returns a promise)
                    response.json().then((infofromserver) => {
                        console.log(infofromserver);
                        console.log(infofromserver.data);
                    })
                }
            }).catch((err) => {
                console.error(err);
            })
    }
    readAllTasks();


    const readAllToDo = () => {
        fetch("http://localhost:8080/todo/readAll")
            .then((response) => {
                if (response.status !== 200) {
                    throw new Error("Error, this has not worked");
                } else {
                    console.log(response);
                    console.log(`OK - 200, this has worked`);
                    //json-ify it (which returns a promise)
                    response.json().then((infofromserver) => {
                        console.log(infofromserver);
                        console.log(infofromserver.data);
                    })
                }
            }).catch((err) => {
                console.error(err);
            })
    }
    readAllToDo();


    const deleteTask = () => {
        fetch("http://localhost:8080/task/delete/1")
            .then((response) => {
                if (response.status !== 200) {
                    throw new Error("Error, this has not worked");
                } else {
                    console.log(response);
                    console.log(`OK - 200, this has worked`);
                    //json-ify it (which returns a promise)
                    response.json().then((infofromserver) => {
                        console.log(infofromserver);
                        console.log(infofromserver.data);
                    })
                }
            }).catch((err) => {
                console.error(err);
            })
    }
;