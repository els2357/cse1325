#include "Matrix3.h"
#include <fstream>
#include <vector>
#include <sstream>

int main(int argc, char* argv[]) {
	Matrix3 sum_matrix;
	for(int i=2; i<(argc); i++)
	{
		std::string file{argv[i]};
		std::ifstream ist{file};
		if (!ist) throw std::runtime_error{"Can't open input file " + file};
	
		std::string s;
		std::vector<int> m;
		while (std::getline(ist, s)){
			std::stringstream lineStream(s);
			int value;
			while(lineStream >> value)
				m.push_back(value);
		}	

		Matrix3 matrix{m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8]};
		sum_matrix = matrix + sum_matrix;
	}	
	
	std::string ofile{argv[1]};
	std::ofstream ofs{ofile};
	if (!ofs) throw std::runtime_error{"Can't open output file " + ofile};
	
	ofs << sum_matrix;
	
}
