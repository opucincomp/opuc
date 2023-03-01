## Changes to be done on client side

> Copy ca.pem, cert.pem and key.pem into the client machine and run the below setps
```bash	
mkdir -pv ~/.docker
cp -v {ca,cert,key}.pem ~/.docker
export DOCKER_HOST=tcp://$HOST:4243 DOCKER_TLS_VERIFY=1
docker --tlsverify --tlscacert=pathto/ca.pem --tlscert=pathto/cert.pem --tlskey=pathto/key.pem -H=(DOCKER HOST URL):4243 version
```
