# Cloud Native Application
CSYE 6225

### Assignment 1
```
brew services start postgresql
```
```
curl -vvvv http://localhost:8080/healthz 
```
```
curl -vvvv -XPUT http://localhost:8080/healthz
```
```
brew services stop postgresql
```
Notes:
- Encrypted DB password in application.yml using [Jasypt](http://www.jasypt.org/)
- Made password required for localhost in /opt/homebrew/var/postgresql@14/pg_hba.conf
```
cat /opt/homebrew/var/postgresql@14/pg_hba.conf
```