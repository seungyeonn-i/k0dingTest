import sys
def closestColor(pixels):
    colors = {
        "Black": (0, 0, 0),
        "White": (255, 255, 255),
        "Red": (255, 0, 0),
        "Green": (0, 255, 0),
        "Blue": (0, 0, 255)
    }
    
    result = []
    
    for pixel in pixels:

        red, green, blue = int(pixel[0:8], 2), int(pixel[8:16], 2), int(pixel[16:24], 2)
        
        min = sys.maxsize
        answer = ""
        
        for color, (check_red, check_green, check_blue) in colors.items():
            d = ((red - check_red) ** 2 + (green - check_green) ** 2 + (blue - check_blue) ** 2)
            if d < min:
                min = d
                answer = color
            elif d == min:
                answer = "Ambiguous"
        result.append(answer)
    
    return result