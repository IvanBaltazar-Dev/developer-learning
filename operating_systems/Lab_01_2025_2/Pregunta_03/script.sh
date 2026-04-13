#!/usr/bin/env bash
set -euo pipefail

patron="${1:-}"
digitos="${2:-}"

if [[ -z "$patron" || -z "$digitos" ]]; then
  echo "Uso: $0 <patron> <digitos>" >&2
  exit 1
fi

for path in "${patron}"*; do
  fname="${path##*/}"
  sufijo="${fname#"$patron"}"

  if [[ ! "$sufijo" =~ ^[0-9]+$ ]]; then
    continue
  fi
	
  printf -v padded "%0*d" "$digitos" "$sufijo"
  new_name="${patron}_${padded}" 
  
  if [[ "$fname" == "$new_name" ]]
  then 
	  continue 
  fi
  
  mv -- "$path" "${patron}_${padded}"
done
