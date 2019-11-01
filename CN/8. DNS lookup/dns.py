# DNS Lookup python

import socket

val=int(input(" 1. Name to address \n 2. Address to name \t"))

if val==1:
        name=input("\tEnter Name\t")
        hostaddr = socket.gethostbyname(name)
        print("\n\t Host Address : " +hostaddr)
elif val==2:
        addr=input("\tEnter Address\t")
        hostname = socket.gethostbyaddr(addr)
        print("\n\t Hostname : " +hostname[0])
else :
        print("\tEnter valid choice")
        
"""
OUTPUT :
rutuja@rutuja-HP-240-G6-Notebook-PC:~/CN$ python dns.py
 1. Name to address 
 2. Address to name 	1
	Enter Name	facebook.com

	 Host Address : 31.13.79.35
"""
