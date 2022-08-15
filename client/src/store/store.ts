import { configureStore } from '@reduxjs/toolkit';
import { setupListeners } from '@reduxjs/toolkit/query';
import { personApi } from './personApi';

personApi.enhanceEndpoints({
    endpoints: {
        updatePerson: {
            onQueryStarted: async (args, api) => {
                const res = await api.queryFulfilled;

                const updateQueryAction = personApi.util.updateQueryData('getPeople', undefined, (draft) => {
                    draft.find(person => person.id === args.personId)!.name = res.data.name;
                });
                
                api.dispatch(updateQueryAction);
            }
        }
    }
})

export const store = configureStore({
    reducer: {
        [personApi.reducerPath]: personApi.reducer,
    },
    middleware: (getDefault) => getDefault().concat(personApi.middleware),
});

setupListeners(store.dispatch);
