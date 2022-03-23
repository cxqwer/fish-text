#language:ru
@all
Функциональность: GET запрос FishText API

  Структура сценария: Ответ в формате JSON. [type, number] = [<type>, <number>]
    * GET fish-text. Format .json
      | Parameter          | Value       |
      | HTTP Code          | <httpCode>  |
      | type               | <type>      |
      | number             | <number>    |
      | response.status    | <status>    |
      | response.textError | <text>      |
      | response.errorCode | <errorCode> |
    Примеры:
      | type      | number | status  | text | errorCode | httpCode |
      | sentence  | 1      | success | null | null      | 200      |
      | sentence  | 99     | success | null | null      | 200      |
      | sentence  | 100    | success | null | null      | 200      |
      | sentence  | 101    | success | null | null      | 200      |
      | sentence  | 499    | success | null | null      | 200      |
      | sentence  | 500    | success | null | null      | 200      |
      | paragraph | 99     | success | null | null      | 200      |
      | paragraph | 100    | success | null | null      | 200      |
      | paragraph | 101    | success | null | null      | 200      |
      | paragraph | 499    | success | null | null      | 200      |
      | paragraph | 500    | success | null | null      | 200      |
      | paragraph | 1      | success | null | null      | 200      |
      | title     | 100    | success | null | null      | 200      |
      | title     | 101    | success | null | null      | 200      |
      | title     | 499    | success | null | null      | 200      |
      | title     | 500    | success | null | null      | 200      |
      | title     | 1      | success | null | null      | 200      |
      | title     | 99     | success | null | null      | 200      |

  Структура сценария: Ответ в формате JSON. [type, number] = [<type>, <number>]
    * GET fish-text. Format .json
      | Parameter          | Value       |
      | HTTP Code          | <httpCode>  |
      | type               | <type>      |
      | number             | <number>    |
      | response.status    | <status>    |
      | response.textError | <text>      |
      | response.errorCode | <errorCode> |
    Примеры:
      | type      | number | status  | text | errorCode | httpCode |
      | sentence  | 1      | success | null | null      | 200      |