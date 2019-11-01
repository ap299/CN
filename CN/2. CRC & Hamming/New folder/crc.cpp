#include<iostream>
using namespace std;

int main(){
	//for frame	
	int framesize, frame[20];
	cout<<"Enter the size of frame: ";
	cin>>framesize;
	
	cout<<"Enter frame"<<endl;
	for(int i =0 ;i<framesize; i++){
		cout<<"Enter "<<i<<" bit: ";
		cin>>frame[i];	
	}
	
	//for generator
	int generatorsize, generator[20];
	cout<<"Enter size of generator: ";
	cin>>generatorsize;
	
	cout<<"Enter generator"<<endl;
	for(int i =0 ;i<generatorsize;i++){
		cout<<"Enter "<<i<<" bit: ";
		cin>>generator[i];
	}
	
	//sender//sender//sender//sender//sender//sender//sender//sender//sender//sender//sender//sender//sender
	cout<<"\n        Sender"<<endl;
	cout<<"------------------------"<<endl;
	cout<<"Frame                  : ";
	for(int i=0; i<framesize; i++){
		cout<<frame[i];	
	}
	cout<<"\nGenerator              : ";
	for(int i=0; i<generatorsize; i++){
		cout<<generator[i];	
	}
	int temp[20];
	for(int i=0; i<framesize; i++){
		temp[i] = frame[i];	
	}	
	
	
	//append 0s in frame
	int appendsize = generatorsize-1;
	for(int i = framesize; i<=framesize+appendsize; i++){
		temp[i] = 0;	
	}
	cout<<"\nNo. of zeros appended  : "<<appendsize;
	cout<<"\nAppended Frame         : ";
	for(int i=0; i<(framesize+appendsize); i++){
		cout<<temp[i];	
	}
	
	
	//performing XOR division
	int i,j,k,l;
	for(i=0; i<framesize; i++){
		j=0;k=i;
		if(temp[k]>=generator[j]){
			for(j=0,k=i;j<generatorsize;j++,k++){
				if(temp[k]==generator[j])
					temp[k]=0;
				else
					temp[k]=1;			
			}		
		}
	}
	//finding crc bits
	int crc[10];
	for(i=0,j=framesize; i<appendsize; i++,j++){
		crc[i] = temp[j];
	}
	cout<<"\nCRC bits               : ";
	for(i=0;i<appendsize;i++){
		cout<<crc[i];	
	}
	//replace appended bits with crc bits
	for(i=framesize,j=0;i<(framesize+appendsize);i++,j++){
		frame[i] = crc[j];	
	}
	cout<<"\nTransmited frame       : ";
	for(i=0;i<(framesize+appendsize); i++){
		cout<<frame[i];	
	}
	
	//receiver//receiver//receiver//receiver//receiver//receiver//receiver//receiver//receiver//receiver
	cout<<"\n\n        Receiver"<<endl;
	cout<<"--------------------------"<<endl;
	cout<<"\nReceived frame         : ";
	for(i=0;i<(framesize+appendsize); i++){
		cout<<frame[i];
		temp[i] = frame[i];	
	}
	for(i=0; i<(framesize+appendsize); i++){
		j=0;k=i;
		if(temp[k]>=generator[j]){
			for(j=0,k=i;j<generatorsize;j++,k++){
				if(temp[k]==generator[j])
					temp[k]=0;
				else
					temp[k]=1;			
			}		
		}
	}
	//calculating remainder
	int remainder[15];
	for(i=framesize,j=0;i<(framesize+appendsize);i++,j++){
		remainder[j] = temp[i];	
	}
	cout<<"\nRemainder is           : ";
	for(i=0;i<appendsize;i++){
		cout<<remainder[i];	
	}
	int flag = 0;
	for(i=0; i<appendsize; i++){
		if (remainder[i]==1){
			flag=1;
			break;
		}	
	}
	if(flag==0){
		cout<<"\nSince remainder is 0. Therefore message is successfully transmitted"<<endl;
	}else{
		cout<<"\nOpps.. there is an error in transmission"<<endl;
	}
	
	return 0;
}