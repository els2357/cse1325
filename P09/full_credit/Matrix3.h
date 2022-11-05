#ifndef _MATRIX3_H
#define _MATRIX3_H

#include <iostream>

class Matrix3 {
	public:
		Matrix3();
		Matrix3(int m00, int m01, int m02, int m10, int m11, int m12, int m20, int m21, int m22);
		int get(int x, int y);
		friend std::ostream& operator<<(std::ostream& os, const Matrix3& matrix);
		friend std::istream& operator>>(std::istream& is, Matrix3& matrix);
		Matrix3 operator+(Matrix3 rhs);
	private:
		int _data[3][3];
};
#endif
