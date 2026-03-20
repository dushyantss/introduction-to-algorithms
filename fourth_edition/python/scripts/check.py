"""Unified check script: lint, format, typecheck, and test."""

import subprocess
import sys


def run(
    name: str, cmd: list[str], *, ok_codes: frozenset[int] = frozenset({0})
) -> bool:
    """Run a command, stream its output, and return True if it succeeded."""
    print(f"\n{'=' * 60}")
    print(f"  {name}")
    print(f"{'=' * 60}\n")
    result = subprocess.run(cmd)
    return result.returncode in ok_codes


def main() -> int:
    if "--fix" in sys.argv:
        run("ruff fix", ["ruff", "check", "--fix", "."])
        run("ruff format", ["ruff", "format", "."])

    checks: list[tuple[str, list[str], frozenset[int]]] = [
        ("ruff check", ["ruff", "check", "."], frozenset({0})),
        ("ruff format", ["ruff", "format", "--check", "."], frozenset({0})),
        ("ty check", ["ty", "check"], frozenset({0})),
        ("pytest", ["pytest"], frozenset({0, 5})),  # 5 = no tests collected
    ]

    results: dict[str, bool] = {}
    for name, cmd, ok_codes in checks:
        results[name] = run(name, cmd, ok_codes=ok_codes)

    # Summary table
    print(f"\n{'=' * 60}")
    print(f"  {'Check':<20} {'Result':>10}")
    print(f"  {'-' * 20} {'-' * 10}")
    for name, passed in results.items():
        status = "PASS" if passed else "FAIL"
        print(f"  {name:<20} {status:>10}")
    print(f"{'=' * 60}\n")

    if all(results.values()):
        print("All checks passed.")
        return 0
    else:
        failed = [n for n, p in results.items() if not p]
        print(f"Failed: {', '.join(failed)}")
        return 1


if __name__ == "__main__":
    sys.exit(main())
