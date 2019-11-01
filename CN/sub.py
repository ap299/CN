import sys

(addrString,cidrString) = sys.argv[1].split("/")

addr = addrString.split(".")

cidr = int(cidrString)

if cidr <= 8:
	print("\nAddress beongs to class A")

elif (cidr > 8) and (cidr <= 16):
	print("\nAddress beongs to class B")

elif (cidr > 16) and (cidr <= 32):
	print("\nAddress beongs to class C")

else:
	print("\nInvalid CIDR value!")

print("\nTotal number of network bits are: "+str(cidr))
host = 32 - cidr
print("\nTotal number of host bits are: "+str(host))
total_nw_bit = 24-cidr
total_nw = 2**total_nw_bit
print("\nTotal number of networks that can be formed are: "+str(total_nw))
total_ip = 2*host
total_ip = total_ip-1
print("\nTotal number of ip address in each field are: "+str(total_ip))
total_host = total_ip-1
print("\nTotal number of host ip address in each network: "+str(total_host))

mask=[0,0,0,0]

for i in range(cidr):
	mask[i//8] = mask[i // 8] + (1 << (7 - i % 8))

net = []

for i in range(4):
	net.append(int(addr[i]) & mask[i])

broad = list(net)
brange = 32-cidr

for i in range(brange):
	broad[3 - i//8] = broad[3 - i//8] + (1 << (7 - i%8))

print("Address:   " , addrString)
print("Netmask:   " , ".".join(map(str,mask)))
print("Network:   " , ".".join(map(str,net)))
print("Broadcast: " , ".".join(map(str,broad)))