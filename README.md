# SeatingArrangement

Hi! This is java based application that takes text (txt) file as input and produces seating arrangement as output.

## Criteria

- 4 Branches with max 40 students each.
- Hall ticket number has first two alphabets (EC, EE, CS, ME) and followed by 5 numbers.
- No two branches are side by side.
- No two branches are one after the other.

## Tools and Dependencies Used

- Maven, JUnit.

## Approach

- Store next possible position branch after each allocation.
- Use next possible position to reduce traversing.
- Fix rows as 80 considering max 40 students per branch and 3 columns as per expected output.

## Test Cases

- Check neighbour are of different branch.
- Ensure index out of bound doesn't occur due to wrong looping.
- Ensure wrong branches aren't considered.
- Ensure wrong hallticket aren't considered.

## Execution

- Edit hallticket.txt file and place content. Ensure path same as jar path or if executing from IDE it shall be same as pom.xml path.
