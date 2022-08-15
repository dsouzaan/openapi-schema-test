import { baseApi as api } from "./api";
export const addTagTypes = ["people"] as const;
const injectedRtkApi = api
  .enhanceEndpoints({
    addTagTypes,
  })
  .injectEndpoints({
    endpoints: (build) => ({
      getPeople: build.query<GetPeopleApiResponse, GetPeopleApiArg>({
        query: () => ({ url: `/people` }),
        providesTags: ["people"],
      }),
      createPerson: build.mutation<CreatePersonApiResponse, CreatePersonApiArg>(
        {
          query: (queryArg) => ({
            url: `/people`,
            method: "POST",
            body: queryArg.person,
          }),
          invalidatesTags: ["people"],
        }
      ),
      getPerson: build.query<GetPersonApiResponse, GetPersonApiArg>({
        query: (queryArg) => ({ url: `/people/${queryArg.personId}` }),
        providesTags: ["people"],
      }),
      updatePerson: build.mutation<UpdatePersonApiResponse, UpdatePersonApiArg>(
        {
          query: (queryArg) => ({
            url: `/people/${queryArg.personId}`,
            method: "PUT",
            body: queryArg.person,
          }),
        }
      ),
      removePerson: build.mutation<RemovePersonApiResponse, RemovePersonApiArg>(
        {
          query: (queryArg) => ({
            url: `/people/${queryArg.personId}`,
            method: "DELETE",
          }),
          invalidatesTags: ["people"],
        }
      ),
    }),
    overrideExisting: false,
  });
export { injectedRtkApi as personApi };
export type GetPeopleApiResponse =
  /** status 200 List of all people */ Person[];
export type GetPeopleApiArg = void;
export type CreatePersonApiResponse = /** status 200 Success */ Person;
export type CreatePersonApiArg = {
  person: Person;
};
export type GetPersonApiResponse =
  /** status 200 Name for a specific person */ Person;
export type GetPersonApiArg = {
  /** The id of the person to retrieve */
  personId: string;
};
export type UpdatePersonApiResponse = /** status 200 Success */ Person;
export type UpdatePersonApiArg = {
  /** The id of the person to retrieve */
  personId: string;
  person: Person;
};
export type RemovePersonApiResponse = unknown;
export type RemovePersonApiArg = {
  /** The id of the person to retrieve */
  personId: string;
};
export type Person = {
  id?: string;
  name: string;
};
export const {
  useGetPeopleQuery,
  useCreatePersonMutation,
  useGetPersonQuery,
  useUpdatePersonMutation,
  useRemovePersonMutation,
} = injectedRtkApi;
