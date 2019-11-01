
import sys

# Get address string and CIDR string from command line
(addString, cidrString) = sys.argv[1].split('/')

# Split address into octets and turn CIDR into int
addr = addString.split('.')
# print(addr)
cidr = int(cidrString)
# print(cidr)

if cidr <= 8:
    print('\nYour IP address belongs to class A')
elif (cidr <= 16) and (cidr > 8):
	print('\nYour IP address belongs to class B')
elif (cidr < 32) and (cidr > 16):
	print('\nYour IP address belongs to class C')
else:
	print('\nYou entered invalid CIDR. Exiting...')
	exit()

print('\nTotal number of network bits are : '+str(cidr))
host = 32 - cidr
print('\nSince ipv4 address is 32 bit, So remaining host bits are: ' + str(host))
total_nw_bit = 24-cidr
total_nw = 2**total_nw_bit
print('\nTotal number of network to be formed: '+str(total_nw))
total_ip = 2**host
total_ip = total_ip-1
print('\nTotal number of ip address in each network: '+str(total_ip))
total_host = total_ip-2
print('\nTotal number of host ip address in each network: '+str(total_host)+"\n\n")

# Initialize the netmask and calculate based on CIDR mask
mask = [0, 0, 0, 0]
for i in range(cidr):
    # print('\ni = ',i)
    # print('MASK -> mask[i//8] = ',mask[i//8])
    # print('i%8 =  ',i % 8)
    # print('7-i%8 = ',7 - i % 8)
    # print(mask)
    mask[i//8] = mask[i//8] + (1 << (7 - i % 8))

# Initialize net and binary and netmask with addr to get network
net = []
for i in range(4):
    # print("{} AND {}".format(int(addr[i]),mask[i]))
    net.append(int(addr[i]) & mask[i])
    # print(net)

# Duplicate net into broad array, gather host bits, and generate broadcast
broad = list(net)
brange = 32 - cidr
for i in range(brange):
	broad[3 - i//8] = broad[3 - i//8] + (1 << (i % 8))

# Print information, mapping integer lists to strings for easy printing
print ("Address:   " , addString)
print ("Netmask:   " , ".".join(map(str, mask)))
print ("Network:   " , ".".join(map(str, net)))
print ("Broadcast: " , ".".join(map(str, broad)))
