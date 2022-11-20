const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const mysql = require('mysql');
 
// parse application/json
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
 
//create database connection
const conn = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'db_express'
});
 
//connect to database
conn.connect((err) =>{
  if(err) throw err;
  console.log('Mysql Connected...');
});
 

app.get('/api/user',(req, res) => {
  let sql = "SELECT * FROM user";
  let query = conn.query(sql, (err, results) => {
    if(err) throw err;
    res.send(JSON.stringify({"status": 200, "error": null, "response": results}));
  });
});
 

app.post('/api/user',(req, res) => {

  let data = {
  user_id : req.body.user_id,
  user_password : req.body.user_password};
  let sql = "SELECT * FROM user WHERE user_id = '"+req.body.user_id+"' AND user_password = '"+req.body.user_password+"'";
  let query = conn.query(sql, data,(err, results) => {
    if(err) throw err;
    if(results == '') {
        results = "Data tidak ditemukan"
    }
    res.send(JSON.stringify({"status": 200, "error": null, "response": results}));
  });
});
 
 
//Server listening
app.listen(3000,'10.208.205.188',() =>{
  console.log('Server started on port 3000...');
});