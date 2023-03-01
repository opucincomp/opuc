## Changes required on Windows

[Docker Download](https://download.docker.com/win/static/stable/x86_64/)
Download, Unzip and set path to this folder
Open C:\Users\youruser
> Copy ca.pem, cert.pem and key.pem into the client machine and run the below setps
Go to adderss bar and type cmd run

```powershell
mkdir .docker
```
> Copy ca.pem, cert.pem and key.pem into the .docker folder

Open power shell and run
```powershell
set DOCKER_HOST=tcp://(DOCKER HOST URL):4243 
set DOCKER_TLS_VERIFY=1

docker --tlsverify --tlscacert=pathto/ca.pem --tlscert=pathto/cert.pem --tlskey=pathto/key.pem -H=(DOCKER HOST URL):4243 version
```

