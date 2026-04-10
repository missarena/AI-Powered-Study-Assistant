import { useEffect, useState } from "react";
import axios from "axios";

function Notes() {
    const [notes, setNotes] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/MyNotes", {
            withCredentials: true
        })
            .then(res => {
                console.log(res.data)
                setNotes(res.data)
            })
            .catch(err => console.log(err));
    }, []);

    //console.log(notes);
    return (
        <div>
            <h2>Your Notes</h2>

        </div>
    );
}

export default Notes;