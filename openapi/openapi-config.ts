import { ConfigFile } from '@rtk-query/codegen-openapi';

const config: ConfigFile = {
    schemaFile: './api.yaml',
    apiFile: '../client/src/store/api.ts',
    apiImport: 'baseApi',
    outputFile: '../client/src/store/personApi.ts',
    exportName: 'personApi',
    tag: true,
    hooks: true,
};

export default config;
