# spring-boot-couchbase-with-expire

Search without any index creation
-------------------------------------
SELECT META(`bucketName`).id AS _ID, *  from `bucketName` 
use keys['id']
