FROM ubuntu:latest
 
#
# Identify the maintainer of an image
LABEL maintainer="myname@somecompany.com"
 
#
# Update the image to the latest packages
RUN apt-get update && apt-get upgrade -y
 
#
# Install NGINX to test.
RUN apt-get install nginx -y
