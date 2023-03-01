# Create & use certificate

**----------------------Server Cert----------------------**
```bash
openssl genrsa -aes256 -out ca-key.pem 4096

openssl req -new -x509 -days 365 -key ca-key.pem -sha256 -out ca.pem

openssl genrsa -out server-key.pem 4096



openssl req -subj "/CN=$HOST" -sha256 -new -key server-key.pem -out server.csr


echo subjectAltName = DNS:$HOST,IP:192.168.107.130,IP:192.168.107.131,IP:192.168.107.132,IP:192.168.107.133,IP:192.168.107.134,IP:127.0.0.1 >> extfile.cnf
echo extendedKeyUsage = serverAuth >> extfile.cnf


openssl x509 -req -days 365 -sha256 -in server.csr -CA ca.pem -CAkey ca-key.pem -CAcreateserial -out server-cert.pem -extfile extfile.cnf
```
	
**----------------------Client Cert-key----------------------**
```bash
openssl genrsa -out key.pem 4096
	
	
openssl req -subj '/CN=client' -new -key key.pem -out client.csr

echo extendedKeyUsage = clientAuth > extfile-client.cnf

openssl x509 -req -days 365 -sha256 -in client.csr -CA ca.pem -CAkey ca-key.pem -CAcreateserial -out cert.pem -extfile extfile-client.cnf
```
```bash 
rm -v client.csr server.csr extfile.cnf extfile-client.cnf
chmod -v 0400 ca-key.pem key.pem server-key.pem
chmod -v 0444 ca.pem server-cert.pem cert.pem
```
## Canges to be done on server side

```bash
systemctl edit docker
```
search for docker.service path and open as shown below
vim /lib/systemd/system/docker.service 

```bash
ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:4243 -H unix:///var/run/docker.sock --tlsverify --tlscacert=/pathto/ca.pem --tlscert=/pathto/server-cert.pem  --tlskey=/pathto/server-key.pem
```
**Edit IP tables**
```bash
firewall-cmd --zone=public --permanent --add-port 4243/tcp
firewall-cmd --reload

# Start Docker
sudo systemctl daemon-reload
sudo systemctl restart docker 
```
