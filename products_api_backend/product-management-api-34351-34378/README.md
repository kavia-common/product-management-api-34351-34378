# product-management-api-34351-34378

Backend container: products_api_backend

## Run
- Starts automatically in the preview environment.
- Swagger UI: /docs route redirects to /swagger-ui.html
- OpenAPI JSON: /api-docs

Example base URL (from preview info): https://vscode-internal-31677-qa.qa01.cloud.kavia.ai:3001

## Endpoints
- GET /products
- GET /products/{id}
- POST /products
- PUT /products/{id}
- DELETE /products/{id}

## Validation
- name: required (non-blank)
- price: >= 0
- quantity: >= 0

## cURL Examples
Replace ${BASE} with your base URL.

List:
curl -s "${BASE}/products" | jq .

Get by id:
curl -s "${BASE}/products/1" | jq .

Create:
curl -s -X POST "${BASE}/products" \
  -H "Content-Type: application/json" \
  -d '{"name":"New Product","price":12.34,"quantity":5}' | jq .

Update:
curl -s -X PUT "${BASE}/products/1" \
  -H "Content-Type: application/json" \
  -d '{"name":"Updated","price":15.00,"quantity":8}' | jq .

Delete:
curl -i -X DELETE "${BASE}/products/1"

## Database
Defaults to in-memory H2. To use an external DB (like products_database), set:
- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_DRIVER_CLASS_NAME
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- SPRING_JPA_DATABASE_PLATFORM
- SPRING_JPA_HIBERNATE_DDL_AUTO

Sample data is seeded via src/main/resources/data.sql.
