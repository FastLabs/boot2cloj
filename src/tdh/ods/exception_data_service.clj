(ns tdh.ods.exception-data-service)

(defprotocol ExceptionDataService
  (find-exception-type [this excp-type-code]
                       [this excp-type-code source-type]
                       "lookups the exception type using the exception-type code and"))