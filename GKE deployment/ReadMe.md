The pod4.yml is the Dropwizard API exposed as a NodePort service on 9090
The pod5.yml is the Hystrix Operational Menu exposed as a NodePort Service on 9091
The services are added to the ingress.yml which will create a LoadBalancer visible here https://console.cloud.google.com/net-services/loadbalancing/list/loadBalancers
The iap.yml is the backend config, for more information please take a look at this guide https://cloud.google.com/iap/docs/enabling-kubernetes-howto
Hosted on https://hystrix.sndr.in/ with IAP enabled
