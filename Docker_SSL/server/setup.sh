#!/bin/bash
#
#
#
#
#

sudo yum install -y yum-utils \

sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo

sed -i -e 's/baseurl=https:\/\/download\.docker\.com\/linux\/\(fedora\|rhel\)\/$releasever/baseurl\=https:\/\/download.docker.com\/linux\/centos\/$releasever/g' /etc/yum.repos.d/docker-ce.repo

sudo yum install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin