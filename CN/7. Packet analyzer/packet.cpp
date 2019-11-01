/*
In this program, we are capturing all the packets from Wireshark software.
After capturing them we are saving them in  a text file
and then counting the total number of Ethernet, IP, UDP, TCP protocols from these packets.
*/

#include<iostream>
#include<fstream>
#include<string>
using namespace std;

int main()
{
long udp, tcp, ip4, ip6, ethernet, extras;
udp = tcp = ip4 = ip6 = ethernet = extras = 0;

ifstream in("log.txt");
cout<<"Packets format captured through wireshark's protocol count : \n\n";

if(!in) {
    cout<< "Failed to open log file";
    return 1;
}

char str[1000];

while(in)
{
    in.getline(str, 1000);
    in.getline(str, 1000);
    in.getline(str, 1000);

    if(in)
    {

        if(str[48] == '4')  //ipv4
        {
            ip4++;
            if(str[75] == '1' && str[76] == '1')
            {
                udp++;
            }
            else if(str[75] == '0' && str[76] == '6')
            {
                tcp++;
            }

        }
        else if(str[48] == '6') //ipv6
        {
            ip6++;
            if(str[66] == '1' && str[67] == '1')
            {
                udp++;
            }
            else if(str[66] == '0' && str[67] == '6')
            {
                tcp++;
            }
        }



        else
            extras++;
        ethernet++;
    }
    in.getline(str, 1000);
}
in.close();

cout<<"\nEthernet : "<<ethernet<<"\n\tIP :"<<ip4+ip6<<"\n\t\tIPv4 :"<<ip4<<"\n\t\tIPv6 :"<<ip6<<"\n\t\tUDP: "<<udp<<"\n\t\tTCP :"<<tcp<<"\n\tExtras : "<<extras<<endl;

return 0;
}
