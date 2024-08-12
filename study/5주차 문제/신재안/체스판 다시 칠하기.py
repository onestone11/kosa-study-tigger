userInput = input().split(' ')
N = int(userInput[0])
M = int(userInput[1])

answer = 65

whiteStarts = ['W', 'B'] * 4
blackStarts = ['B', 'W'] * 4
whiteStartChessBoard = [
  whiteStarts,
  blackStarts,
  whiteStarts,
  blackStarts,
  whiteStarts,
  blackStarts,
  whiteStarts,
  blackStarts
]
blackStartChessBoard = [
  blackStarts,
  whiteStarts,
  blackStarts,
  whiteStarts,
  blackStarts,
  whiteStarts,
  blackStarts,
  whiteStarts
]

def checkRepaintCount(board, referenceBoard):
  repaintCount = 0
  for row, refRow in zip(board, referenceBoard):
    for square, refSquare in zip(row, refRow):
      if square != refSquare:
        repaintCount += 1
  return repaintCount

board = [0]* N
for i in range(N):
  board[i] = input()

for i in range(N-7):
  for j in range(M-7):
    for partOfBoard in board[i:i+8]:
      boardSegment = [row[j:j+8] for row in board[i:i+8]]

    whiteStartRepaintCount = checkRepaintCount(boardSegment, whiteStartChessBoard)
    blackStartRepaintCount = checkRepaintCount(boardSegment, blackStartChessBoard)

    answer = min(answer, whiteStartRepaintCount, blackStartRepaintCount)

print(answer)
