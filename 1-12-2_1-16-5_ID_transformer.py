import os
import json
import argparse

def replace_strings_in_file(file_path, replace_dict, reverse=False):
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            content = file.read()

        if reverse:
            for old_str, new_str in replace_dict.items():
                content = content.replace(new_str, old_str)
        else:
            for old_str, new_str in replace_dict.items():
                content = content.replace(old_str, new_str)

        with open(file_path, 'w', encoding='utf-8') as file:
            file.write(content)

        print(f"Modified: {file_path}")

    except Exception as e:
        print(f"Error processing {file_path}: {e}")

def process_directory(directory_path, replace_dict, filetypes, reverse=False):
    for root, _, files in os.walk(directory_path):
        for file_name in files:
            file_extension = file_name.split('.')[-1]
            if file_extension in filetypes:
                file_path = os.path.join(root, file_name)
                replace_strings_in_file(file_path, replace_dict, reverse)

def main():
    parser = argparse.ArgumentParser(description="Replace or reverse replacements in files.")
    parser.add_argument("directory_path", nargs="?", default="./mccore/src/main/resources/assets", help="Directory path to start the replacement")
    parser.add_argument("json_file_path", nargs="?", default="./1-12-2_1-16-5_dictionnary.json", help="JSON file path with replacement dictionary")
    parser.add_argument("--reverse", action="store_true", help="Reverse replacements")
    args = parser.parse_args()

    try:
        with open(args.json_file_path, 'r', encoding='utf-8') as json_file:
            config = json.load(json_file)
            replace_dict = config.get("replacements", {})
            filetypes = config.get("filetypes", [])
    except Exception as e:
        print(f"Error loading JSON file: {e}")
        return

    process_directory(args.directory_path, replace_dict, filetypes, args.reverse)
    action = "Reversed" if args.reverse else "Replaced"
    print(f"{action} completed!")

if __name__ == "__main__":
    main()
