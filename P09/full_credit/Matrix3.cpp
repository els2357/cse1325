#include "Matrix3.h"
Matrix3::Matrix3()
	:_data{{{0}, {0}, {0}}, {{0}, {0}, {0}}, {{0}, {0}, {0}}} {
	}

Matrix3::Matrix3(int m00, int m01, int m02, int m10, int m11, int m12, int m20, int m21, int m22)
	: _data{{{m00}, {m01}, {m02}}, {{m10}, {m11}, {m12}}, {{m20}, {m21}, {m22}}} {	
	}

int Matrix3::get(int x, int y)
{
	if (x < 0 || x > 2) throw std::runtime_error{"Invalid x"};
	if (y < 0 || y > 2) throw std::runtime_error{"Invalid y"};
	return _data[x][y];
}

std::ostream & operator << (std::ostream &os, const Matrix3 &matrix)
{
	os << matrix._data[0][0] << " " << matrix._data[0][1] << " " << matrix._data[0][2] << '\n'
	   << matrix._data[1][0] << " " << matrix._data[1][1] << " " << matrix._data[1][2] << '\n'
	   << matrix._data[2][0] << " " << matrix._data[2][1] << " " << matrix._data[2][2] << '\n';
	return os;
}

std::istream & operator >> (std::istream &is, Matrix3 &matrix)
{
	is >> matrix._data[0][0];
	is >> matrix._data[0][1];
	is >> matrix._data[0][2];
	is >> matrix._data[1][0];
	is >> matrix._data[1][1];
	is >> matrix._data[1][2];
	is >> matrix._data[2][0]; 
	is >> matrix._data[2][1];
	is >> matrix._data[2][2];
	return is;
}

Matrix3 Matrix3::operator+(Matrix3 rhs){
	Matrix3* sum = new Matrix3(_data[0][0] + rhs.get(0,0), _data[0][1] + rhs.get(0,1), _data[0][2] + rhs.get(0,2),
							  _data[1][0] + rhs.get(1,0), _data[1][1] + rhs.get(1,1), _data[1][2] + rhs.get(1,2),
							  _data[2][0] + rhs.get(2,0), _data[2][1] + rhs.get(2,1), _data[2][2] + rhs.get(2,2));
	return *sum;
}
