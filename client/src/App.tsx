import style from './app.module.css';
import { FC, useState } from 'react';
import {
    useGetPeopleQuery,
    useCreatePersonMutation,
    useUpdatePersonMutation,
    useRemovePersonMutation,
    Person,
} from './store';

type PersonEditorProps = {
    person: Person;
    onEdit: (person: Person) => void;
    onDelete: (id: string) => void;
};

const PersonEditor: FC<PersonEditorProps> = ({ person, ...props }) => {
    const [edit, setEdit] = useState(person);

    return (
        <li>
            <input
                defaultValue={person.name}
                onChange={({ target }) =>
                    setEdit({ ...edit, name: target.value })
                }
            />
            <button onClick={() => props.onEdit(edit)}>update</button>
            <button onClick={() => props.onDelete(person.id!)}>delete</button>
        </li>
    );
};

function App() {
    /* Application state */
    const [person, setPerson] = useState<Person>({ name: '' });
    /* End application state */

    /* Server state */
    const { data, isLoading, isError } = useGetPeopleQuery();

    const [createPerson] = useCreatePersonMutation();

    const [updatePerson] = useUpdatePersonMutation();

    const [removePerson] = useRemovePersonMutation();
    /* End server state */

    if (isLoading) {
        return <div>...loading</div>;
    }

    if (isError) {
        return <div>an error occurred...</div>;
    }

    return (
        <div className={style.app}>
            <div>
                <input
                    placeholder="name"
                    onChange={({ target }) => setPerson({ name: target.value })}
                />
                <button onClick={() => createPerson({ person })}>create</button>
            </div>
            <div>
                <ul>
                    {data?.map((person, i) => (
                        <PersonEditor
                            key={i}
                            person={person}
                            onEdit={(person) =>
                                updatePerson({ personId: person.id!, person })
                            }
                            onDelete={(personId) => removePerson({ personId })}
                        />
                    ))}
                </ul>
            </div>
        </div>
    );
}

export default App;
