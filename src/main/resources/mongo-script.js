db.createCollection('accounts');
db.getCollection("accounts").createIndex({ "documentNumber": 1 }, {unique: true});

db.createCollection('operation-type');
db.getCollection("operation-type").insertMany([
    {
        "_id": NumberLong(1),
        "description": "COMPRA A VISTA",
        "increaseValue": false
    },
    {
        "_id": NumberLong(2),
        "description": "COMPRA PARCELADA",
        "increaseValue": false
    },
    {
        "_id": NumberLong(3),
        "description": "SAQUE",
        "increaseValue": false
    },
    {
        "_id": NumberLong(4),
        "description": "PAGAMENTO",
        "increaseValue": true
    },
]);

db.createCollection('transaction');
db.getCollection("transaction").createIndexes([
    {"accounts._id": 1},
    {"operationType._id": 1},
    {"amount": 1}
]);