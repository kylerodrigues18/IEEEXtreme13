def parser():
    
    pass


def get_word():

    pass


def get_number():

    return int(input())


###########################################################


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y


class Orientation:
    CLOCKWISE = 0
    COUNTERCLOCKWISE = 1
    COLINEAR = 2


###########################################################


import numpy
import scipy

points = list()
polygon = list()
output = 0

polygonCount = get_number()
pointCount = get_number()


def orientation(p1, p2, p3):
    orientation = (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y);
    if orientation > 0:
        return Orientation.CLOCKWISE
    elif orientation == 0:
        return Orientation.COLINEAR
    else:
        return Orientation.COUNTERCLOCKWISE


def intersect(p1, p2, p3, p4):
    o1 = orientation(p1, p2, p3)
    o2 = orientation(p1, p2, p4)
    o3 = orientation(p3, p4, p1)
    o4 = orientation(p3, p4, p2)

    return o1 is not o2 and o3 is not o4


def checkPoints(p1, p2):
    for i in range(0, polygonCount):
        if intersect(p1, p2, polygon[i], polygon[(i+1) % polygonCount]):
            return 0
    return 1


for i in range(0, polygonCount):
    polygon.append(Point(get_number(), get_number()))

for i in range(0, pointCount):
    points.append(Point(get_number(), get_number()))

for i in range(0, len(points) - 1):
    for j in range(i + 1, len(points)):
        output += checkPoints(points[i], points[j])

print(output)
