import mcp

from mcp.server.fastmcp import FastMCP

mcp = FastMCP("architectural_knowledge")


@mcp.tool()
async def add(number1: int, number2: int) -> int:
    return number1 + number2

if __name__ == "__main__":
    mcp.run(transport='stdio')